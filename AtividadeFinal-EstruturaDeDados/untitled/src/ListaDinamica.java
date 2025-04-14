public class ListaDinamica implements IEstruturaDinamica{
    private No primeiro;
    private No ultimo;


    @Override
    public void inserirElemento(Object elemento) {
        No no = new No((Integer) elemento);
        if (estaVazia()){
            this.primeiro = no;
            this.ultimo = no;
        } else {
            this.ultimo.setProx(no);
            no.setAnterior(this.ultimo);
            this.ultimo = no;
        }
    }

    @Override
    public void inserirSequencia(ListaDinamica listaAdicionada) {
        if (estaVazia()){
         this.primeiro = listaAdicionada.primeiro;
         this.ultimo = listaAdicionada.ultimo;
        }else {
            this.ultimo.setProx(listaAdicionada.primeiro);
            listaAdicionada.primeiro.setAnterior(this.ultimo);
            this.ultimo = listaAdicionada.ultimo;
        }
    }

    @Override
    public boolean removerElemento(Object elemento) {
        No aux = this.primeiro;
        if (this.primeiro.getConteudo().equals(elemento)) {
            this.primeiro = this.primeiro.getProx();
            System.out.println("Elemento removido com sucesso " + elemento);
            return true;
        } else {
            try {
                while (aux != null) {
                    if (aux.getProx().getConteudo().equals(elemento)) {
                        if (aux.getProx() == this.ultimo) {
                            aux.setProx(null);
                            this.ultimo = aux;
                            System.out.println("Elemento removido com sucesso " + elemento);
                            return true;
                        } else {
                            aux.setProx(aux.getProx().getProx());
                            aux.getProx().setAnterior(aux);
                            System.out.println("Elemento removido com sucesso " + elemento);
                            return true;
                        }
                    }
                    aux = aux.getProx();
                }
            }catch (Exception e) {
                System.out.println("Não foi possível remover o elemento (" + elemento+ ") da lista, pois não existe!");
                return false;
            }
        }
        return false;
    }

    @Override
    public void removerSequencia(Integer[] elementos) {
        No aux = this.primeiro;
        for (int i = 0; i < elementos.length; i++) {
            this.removerElemento(elementos[i]);
        }
        System.out.println("Os números escolhidos que estavam presentes na Lista foram removidos.");
    }

    @Override
    public void removerTodasOcorrencias(Object elemento) {
        int count = 0;
        while (removerElemento(elemento)) {
            count++;
        }
        System.out.println("Havia " + count + " " + elemento + "s. Todos foram removidos");
    }

    @Override
    public boolean estaCheia() {//Não precisa
        System.out.println("Impossível uma Lista Dinâmica estar cheia.");
        return false;
    }

    @Override
    public boolean estaVazia() {
        return this.primeiro == null;
    }

    @Override
    public boolean buscarElemento(Object elemento) {
        No aux = primeiro;
        while (aux != null) {
            if (aux.getConteudo().equals(elemento)) {
                return true;
            }
            aux = aux.getProx();
        }
        return false;
    }

    @Override
    public void ordenarCrescente() {
        if (estaVazia() || this.quantidadeElementos() == 1){
            System.out.println("A Lista está Vazia ou com apenas um elemento");
            return;
        }
        for (int i = 0; i < this.quantidadeElementos() - 1; i++) {
            No aux = this.primeiro;
            while (aux.getProx() != null) {
                if ((int) aux.getConteudo() > (int) aux.getProx().getConteudo()){
                    int temp = (int) aux.getConteudo();
                    aux.setConteudo(aux.getProx().getConteudo());
                    aux.getProx().setConteudo(temp);
                }
                aux = aux.getProx();
            }
        }

    }


    @Override
    public void ordenarDecrescente() {
        if (estaVazia() || this.quantidadeElementos() == 1){
            System.out.println("A Lista está Vazia ou com apenas um elemento");
            return;
        }
        for (int i = 0; i < this.quantidadeElementos() - 1; i++) {
            No aux = this.primeiro;
            while (aux.getProx() != null) {
                if ((int) aux.getConteudo() < (int) aux.getProx().getConteudo()){
                    int temp = (int) aux.getConteudo();
                    aux.setConteudo(aux.getProx().getConteudo());
                    aux.getProx().setConteudo(temp);
                }
                aux = aux.getProx();
            }
        }

    }

    @Override
    public int quantidadeElementos() {
        No aux = this.primeiro;
        int count = 0;
        if (estaVazia()){
            System.out.println("Lista Vazia");
            return count;
        }else {
            while (aux != null) {
                count++;
                aux = aux.getProx();
            }
            return count;
        }
    }

    @Override
    public void editarElemento(Object elementoAntigo, Object elementoNovo) {
        No aux = this.primeiro;
        while (aux != null) {
            if (aux.getConteudo().equals(elementoAntigo)) {
                aux.setConteudo(elementoNovo);
                return;
            }
            aux = aux.getProx();
        }
    }

    @Override
    public void limpar() {
        this.primeiro = null;
        this.ultimo = null;
    }

    @Override
    public void exibir() {
        No aux = this.primeiro;
        while (aux != null) {
            System.out.println(aux.getConteudo());
            aux = aux.getProx();
        }
    }

    @Override
    public No obterPrimeiroElemento() {
        return this.primeiro;
    }

    @Override
    public No obterUltimoElemento() {
        return this.ultimo;
    }
}
