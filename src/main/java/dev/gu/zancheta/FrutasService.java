package dev.gu.zancheta;

import io.quarkus.arc.Lock;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Lock
@ApplicationScoped
public final class FrutasService {

    @Inject
    IdentificadorTransacao identificadorTransacao;

    @Lock(value = Lock.Type.READ, time = 3, unit = TimeUnit.SECONDS)
    public List<Fruta> list() {
        System.out.println(identificadorTransacao.getIdentificacaoTransacao());
        return Fruta.listAll();
    }

    @Transactional
    public void novaFruta(InserirFrutaDTO inserirFrutaDTO) {
        System.out.println(identificadorTransacao.getIdentificacaoTransacao());
        Fruta fruta = new Fruta();
        fruta.nome = inserirFrutaDTO.getNome();
        fruta.qtd = inserirFrutaDTO.getQtd();
        fruta.persist();
    }
}
