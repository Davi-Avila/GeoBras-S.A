
import type Cliente from '@/interfaces/Cliente'
import type { ObraForm } from '@/interfaces/Obra'
import type { Orcamento } from '@/interfaces/Orcamento'
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

export async function putCliente(cliente: Cliente) {
  await api.put(`/clientes/${cliente.idCliente}`, cliente)
}


//Obra
export async function getObras() {
  const response = await api.get('/obras')
  return response.data
}

export async function postObra(obra: ObraForm) {
  await api.post<ObraForm>('/obras', obra)
}

export async function deleteObra(idObra: number) {
  await api.delete(`/obras/${idObra}`)
}

export async function getObraById(idObra: string | number) {
  const response = await api.get(`/obras/${idObra}`)
  return response.data
}

export async function putObra(obra: ObraForm) {
  await api.put(`/obras/${obra.idObra}`, obra)
}


//Orcamento
export async function getOrcamentos() {
  const response = await api.get('/orcamento')
  return response.data
}

export async function postOrcamento(orcamento: Orcamento) {
  await api.post<Orcamento>('/orcamento', orcamento)
}

export async function deleteOrcamento(idOrcamento: number) {
  await api.delete(`/orcamento/${idOrcamento}`)
}

export async function getOrcamentoById(idOrcamento: string | number) {
  const response = await api.get(`/orcamento/${idOrcamento}`)
  return response.data
}

export async function putOrcamento(orcamento: Orcamento) {
  await api.put(`/orcamento/${orcamento.idOrcamento}`, orcamento)
}

export async function getOrcamentosDisponiveis() {
  const response = await api.get('/orcamento/disponiveis')
  return response.data
  
}