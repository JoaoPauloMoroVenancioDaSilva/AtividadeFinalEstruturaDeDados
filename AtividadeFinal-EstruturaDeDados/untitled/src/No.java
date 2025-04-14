public class No implements INo{
    private Integer conteudo;
    private No prox;
    private No anterior;

    public No(Integer conteudo) {
        this.conteudo = conteudo;
        this.prox = null;
        this.anterior = null;
    }

    @Override
    public No getProx() {
        return this.prox;
    }

    @Override
    public void setProx(No prox) {
        this.prox = prox;
    }

    @Override
    public Object getConteudo() {
        return this.conteudo;
    }

    public void setConteudo(Object conteudo) {
        this.conteudo = (Integer) conteudo;
    }

    @Override
    public No getAnterior() {
        return this.anterior;
    }

    @Override
    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }
}
