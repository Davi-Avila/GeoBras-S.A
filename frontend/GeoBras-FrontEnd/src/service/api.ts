import Cliente from '@/interfaces/Cliente'
import Material from '@/interfaces/Material'
import Obra from '@/interfaces/Obra'
import Orcamento from '@/interfaces/Orcamento'
import axios from 'axios'

const api = axios.create({
  baseURL: 'http://localhost:8080'
})


//Cliente
export async function getClientes() {
  const response = await api.get('/clientes')
  return response.data
}

export async function postCliente(cliente: Cliente) {
  await api.post<Cliente>('/clientes', cliente)
}

export async function deleteCliente(idCliente: number) {
  await api.delete(`/clientes/${idCliente}`)
}

export async function getClienteById(idCliente: string | number) {
  const response = await api.get(`/clientes/${idCliente}`)
  return response.data
}


//Material
export async function getMateriais() {
  const response = await api.get('/materiais')
  return response.data
}

export async function postMaterial(material: Material) {
  await api.post<Material>('/materiais', material)
}

export async function deleteMaterial(idMaterial: number) {
  await api.delete(`/materiais/${idMaterial}`)
}

export async function getMaterialById(idMaterial: string | number) {
  const response = await api.get(`/materiais/${idMaterial}`)
  return response.data
}


//Obra
export async function getObras() {
  const response = await api.get('/obras')
  return response.data
}

export async function postObra(obra: Obra) {
  await api.post<Obra>('/obras', obra)
}

export async function deleteObra(idObra: number) {
  await api.delete(`/obras/${idObra}`)
}

export async function getObraById(idObra: string | number) {
  const response = await api.get(`/obras/${idObra}`)
  return response.data
}


//Orcamento
export async function getOrcamentos() {
  const response = await api.get('/orcamentos')
  return response.data
}

export async function postOrcamento(orcamento: Orcamento) {
  await api.post<Orcamento>('/orcamentos', orcamento)
}

export async function deleteOrcamento(idOrcamento: number) {
  await api.delete(`/clientes/${idOrcamento}`)
}

export async function getOrcamentoById(idOrcamento: string | number) {
  const response = await api.get(`/orcamentos/${idOrcamento}`)
  return response.data
}