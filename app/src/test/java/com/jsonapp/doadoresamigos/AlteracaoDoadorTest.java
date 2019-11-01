package com.jsonapp.doadoresamigos;

import com.jsonapp.doadoresamigos.gestaodoadores.AlteracaoDoador;
import com.jsonapp.doadoresamigos.gestaodoadores.AlteracaoDoadorDal;
import com.jsonapp.doadoresamigos.gestaodoadores.DoadorDto;
import com.jsonapp.doadoresamigos.gestaodoadores.DoadorRepositorio;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AlteracaoDoadorTest {

    private DoadorRepositorio doadorRepositorio;
    private AlteracaoDoadorDal alteracaoDoadorDal;
    private AlteracaoDoador alteracaoDoador;

    @Before
    public void configurarTestes(){
        this.doadorRepositorio = Mockito.mock(DoadorRepositorio.class);
        this.alteracaoDoadorDal = Mockito.mock(AlteracaoDoadorDal.class);

    }

    @Test
    public void deveAlterarDadosDoador(){
        DoadorDto doadorDto = new DoadorDto();
        when(this.alteracaoDoadorDal.obterDadosDoador()).thenReturn(doadorDto);
        when(this.doadorRepositorio.alterar(Mockito.any(DoadorDto.class)));
        this.alteracaoDoador = new AlteracaoDoador(alteracaoDoadorDal, doadorRepositorio);

        this.alteracaoDoador.alterar();

        verify(this.doadorRepositorio).alterar(Mockito.any(DoadorDto.class));
    }
}
