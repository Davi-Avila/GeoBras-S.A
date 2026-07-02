

export default interface Obra{ 
    idObra: number
    nomeObra: String
    endereco: String
    dataInicio: Date
    dataFimPrevisto: Date
    etapa: String
    orcamentoTotal: Number
    nomeCliente: String
    email: String
    idOrcamento: number
}

export interface ObraDetalhes extends Obra {
  nomeOrcamento: string
  orcamentoTotal: number
}
