
import type Cliente from '@/interfaces/Cliente'
import type Obra from '@/interfaces/Obra'
import type Orcamento from '@/interfaces/Orcamento'
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

export async function putCliente(idCliente: number, cliente: Cliente) {
  await api.put(`/clientes/${idCliente}`, cliente)
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

export async function putObra(idObra: number, obra: Obra) {
  await api.put(`/obras/${idObra}`, obra)
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
  await api.delete(`/orcamentos/${idOrcamento}`)
}

export async function getOrcamentoById(idOrcamento: string | number) {
  const response = await api.get(`/orcamentos/${idOrcamento}`)
  return response.data
}

export async function putOrcamento(idOrcamento: number, orcamento: Orcamento) {
  await api.put(`/orcamentos/${idOrcamento}`, orcamento)
}