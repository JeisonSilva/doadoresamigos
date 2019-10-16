package com.jsonapp.doadoresamigos;

import com.jsonapp.doadoresamigos.gestaodoadores.DoadorDto;
import com.jsonapp.doadoresamigos.gestaodoadores.DoadorRepositorio;
import com.jsonapp.doadoresamigos.gestaodoadores.PesquisaDoador;
import com.jsonapp.doadoresamigos.gestaodoadores.PesquisaDoadorDal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PesquisaDoadorTest {

    private PesquisaDoador pesquisaDoador;
    private PesquisaDoadorDal pesquisaDoadorDal;
    private DoadorRepositorio doadorRepositorio;

    @Before
    public void configurarTestes(){

        this.pesquisaDoadorDal = Mockito.mock(PesquisaDoadorDal.class);
        this.doadorRepositorio = Mockito.mock(DoadorRepositorio.class);
        this.pesquisaDoador = new PesquisaDoador(this.pesquisaDoadorDal, this.doadorRepositorio);

        DoadorDto doadorDto = new DoadorDto();
        when(this.pesquisaDoadorDal.obterCodigoPesquisa()).thenReturn(1);
        when(this.doadorRepositorio.pesquisarPorCodigo(Mockito.anyInt())).thenReturn(doadorDto);

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void DevePesquisarUmDoadorPorCodigo(){

        this.pesquisaDoador.pesquisarDoadorPorCodigo();

        verify(this.pesquisaDoadorDal).exibirDoador(Mockito.any(DoadorDto.class));
    }

    @Test
    public void DeveExibirMensagemDePesquisaSemResultado(){
        when(this.doadorRepositorio.pesquisarPorCodigo(Mockito.anyInt())).thenReturn(null);

        this.pesquisaDoador.pesquisarDoadorPorCodigo();

        verify(this.pesquisaDoadorDal).notificarUsuarioDePesquisaSemRetornoDeDados();
    }

    @Test
    public void DeveRetornarMensagemParaInserirCodigoDePesquisa(){
        when(this.pesquisaDoadorDal.obterCodigoPesquisa()).thenReturn(0);

        this.pesquisaDoador.pesquisarDoadorPorCodigo();

        verify(this.pesquisaDoadorDal).notificarUsuarioDeCodigoDoadorInvalido();
    }
}
