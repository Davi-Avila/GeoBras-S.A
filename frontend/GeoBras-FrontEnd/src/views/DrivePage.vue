<script setup lang="ts">
import { ref, onMounted } from 'vue'


// Client ID vindo de variável de ambiente (ver .env.example)
const CLIENT_ID = import.meta.env.VITE_GOOGLE_CLIENT_ID as string
const SCOPES = 'https://www.googleapis.com/auth/drive.readonly'
console.log('DEBUG ENV:', import.meta.env)

const isSignedIn = ref(false)
const accessToken = ref<string | null>(null)
const files = ref<any[]>([])
const loading = ref(false)
const errorMsg = ref('')

let tokenClient: any = null

declare global {
  interface Window {
    google: any
  }
}

onMounted(() => {
  if (!CLIENT_ID) {
    errorMsg.value = 'VITE_GOOGLE_CLIENT_ID não configurado no .env'
    return
  }

  const script = document.createElement('script')
  script.src = 'https://accounts.google.com/gsi/client'
  script.async = true
  script.onload = initGoogleClient
  document.head.appendChild(script)
})

function initGoogleClient() {
  tokenClient = window.google.accounts.oauth2.initTokenClient({
    client_id: CLIENT_ID,
    scope: SCOPES,
    callback: (response: any) => {
      if (response.error) {
        errorMsg.value = 'Erro ao autenticar: ' + response.error
        return
      }
      accessToken.value = response.access_token
      isSignedIn.value = true
      listFiles()
    },
  })
}

function signIn() {
  errorMsg.value = ''
  tokenClient?.requestAccessToken()
}

function signOut() {
  if (accessToken.value) {
    window.google.accounts.oauth2.revoke(accessToken.value, () => {})
  }
  accessToken.value = null
  isSignedIn.value = false
  files.value = []
}

async function listFiles() {
  loading.value = true
  errorMsg.value = ''
  try {
    const response = await fetch(
      'https://www.googleapis.com/drive/v3/files?pageSize=30&orderBy=modifiedTime desc&fields=files(id,name,mimeType,iconLink,webViewLink,thumbnailLink,modifiedTime)',
      {
        headers: {
          Authorization: `Bearer ${accessToken.value}`,
        },
      }
    )
    if (!response.ok) throw new Error('Falha ao buscar arquivos')
    const data = await response.json()
    files.value = data.files || []
  } catch (err: any) {
    errorMsg.value = err.message
  } finally {
    loading.value = false
  }
}

function formatDate(dateStr: string) {
  return new Date(dateStr).toLocaleDateString('pt-BR', {
    day: '2-digit',
    month: '2-digit',
    year: 'numeric',
  })
}
</script>

<template>
  <div class="drive-page">

    <!-- Cabeçalho da página -->
    <div class="page-header">
      <h2><i class="bi bi-hdd-fill me-2"></i>Meus Arquivos do Drive</h2>
      <p class="text-muted mb-0">Visualize os arquivos da sua conta do Google Drive.</p>
    </div>

    <div class="page-content">

      <!-- Estado: não logado -->
      <div v-if="!isSignedIn" class="empty-state">
        <i class="bi bi-google display-4 mb-3 d-block text-primary"></i>
        <p class="mb-3">Conecte sua conta do Google para visualizar seus arquivos.</p>
        <button class="btn btn-primary btn-lg" @click="signIn" :disabled="!CLIENT_ID">
          <i class="bi bi-google me-2"></i>Conectar com Google Drive
        </button>
      </div>

      <!-- Estado: logado -->
      <div v-else>
        <div class="d-flex justify-content-between align-items-center mb-3">
          <span class="badge bg-success">
            <i class="bi bi-check-circle me-1"></i>Conectado
          </span>
          <button class="btn btn-sm btn-outline-secondary" @click="signOut">
            <i class="bi bi-box-arrow-right me-1"></i>Desconectar
          </button>
        </div>

        <div v-if="loading" class="text-center py-5">
          <div class="spinner-border text-primary" role="status"></div>
          <p class="mt-2 text-muted">Carregando arquivos...</p>
        </div>

        <div class="row g-3" v-if="!loading && files.length">
          <div class="col-12 col-sm-6 col-lg-4" v-for="file in files" :key="file.id">
            <a :href="file.webViewLink" target="_blank" class="file-card">
              <img
                v-if="file.thumbnailLink"
                :src="file.thumbnailLink"
                class="file-thumb"
                alt=""
              />
              <div v-else class="file-thumb file-thumb-icon">
                <img :src="file.iconLink" alt="" width="32" height="32" />
              </div>
              <div class="file-info">
                <div class="file-name" :title="file.name">{{ file.name }}</div>
                <div class="file-date">{{ formatDate(file.modifiedTime) }}</div>
              </div>
            </a>
          </div>
        </div>

        <p v-if="!loading && !files.length" class="text-muted text-center py-4">
          Nenhum arquivo encontrado no seu Drive.
        </p>
      </div>

      <div v-if="errorMsg" class="alert alert-danger mt-3">{{ errorMsg }}</div>

    </div>
  </div>
</template>

<style scoped>
.drive-page {
  max-width: 960px;
  margin: 0 auto;
  padding: 24px;
}

.page-header {
  margin-bottom: 24px;
}

.page-header h2 {
  color: #0047ab;
  font-weight: bold;
}

.page-content {
  background: white;
  border-radius: 12px;
  padding: 24px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.06);
}

.empty-state {
  text-align: center;
  padding: 48px 16px;
}

.file-card {
  display: flex;
  align-items: center;
  gap: 12px;
  padding: 10px;
  border: 1px solid #e5e7eb;
  border-radius: 10px;
  text-decoration: none;
  color: inherit;
  transition: box-shadow 0.15s, border-color 0.15s;
  height: 100%;
}

.file-card:hover {
  border-color: #0047ab;
  box-shadow: 0 2px 10px rgba(0, 71, 171, 0.15);
}

.file-thumb {
  width: 48px;
  height: 48px;
  object-fit: cover;
  border-radius: 6px;
  flex-shrink: 0;
}

.file-thumb-icon {
  display: flex;
  align-items: center;
  justify-content: center;
  background: #f2f4f7;
}

.file-info {
  min-width: 0;
}

.file-name {
  font-size: 14px;
  font-weight: 500;
  color: #1a1a1a;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}

.file-date {
  font-size: 12px;
  color: #6b7280;
}

/* Tema escuro (compatível com body.dark do projeto) */
:global(body.dark) .page-content {
  background-color: #2d2d2d;
  color: white;
}

:global(body.dark) .file-card {
  border-color: #555;
  color: white;
}

:global(body.dark) .file-name {
  color: white;
}

:global(body.dark) .file-thumb-icon {
  background: #1f1f1f;
}
</style>
