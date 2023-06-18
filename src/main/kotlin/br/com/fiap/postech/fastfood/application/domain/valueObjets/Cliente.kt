package br.com.fiap.postech.fastfood.application.domain.valueObjets


class CPF(val cpf: String) {
    init {
        require(cpf.trim().length == 11) {
            "CPF deve ser informado"
        }
    }
}

class Nome(val nome: String) {
    init {
        require(nome.trim().length > 0) {
            "Nome deve ser informado"
        }
    }
}

class Email(val email: String) {
    var regex = Regex("^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})")
    init {
        require(regex.containsMatchIn(email)) {
            "E-mail deve ser válido"
        }
    }
}