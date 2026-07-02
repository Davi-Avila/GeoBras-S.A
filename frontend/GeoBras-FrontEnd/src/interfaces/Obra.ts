export interface Obra {
    idObra: number
    nomeObra: string
    endereco: string
    dataInicio: string
    dataFimPrevisto: string
    etapa: string

    orcamentoTotal: number
    nomeCliente: string
    email: string

    idOrcamento: number
    idCliente: number
}