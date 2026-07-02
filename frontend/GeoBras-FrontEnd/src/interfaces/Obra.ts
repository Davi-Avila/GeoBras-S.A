export interface ObraForm {
    idObra: number
    nomeObra: string
    endereco: string
    dataInicio: string
    dataFimPrevisto: string
    etapa: string

    idOrcamento: number
    idCliente: number
}

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
}