package com.jsonapp.doadoresamigos;

import com.jsonapp.doadoresamigos.gestaodoadores.DoadorDto;
import com.jsonapp.doadoresamigos.gestaodoadores.DoadorRepositorio;
import com.jsonapp.doadoresamigos.gestaodoadores.ExclusaoDoador;
import com.jsonapp.doadoresamigos.gestaodoadores.ExclusaoDoadorDal;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ExclusaoDoadorTest {

    private ExclusaoDoadorDal exclusaoDoadorDal;
    private DoadorRepositorio doadorRepositorio;
    private ExclusaoDoador exclusaoDoador;

    @Before
    public void configurarTestes(){
        this.exclusaoDoadorDal = Mockito.mock(ExclusaoDoadorDal.class);
        this.doadorRepositorio = Mockito.mock(DoadorRepositorio.class);
            this.exclusaoDoador = new ExclusaoDoador(this.exclusaoDoadorDal, this.doadorRepositorio);

        when(this.exclusaoDoadorDal.obterCodigoDoador()).thenReturn(1);
        when(this.doadorRepositorio.pesquisarPorCodigo(Mockito.anyInt())).thenReturn(new DoadorDto());

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void DeveExcluirUmDoador(){
        this.exclusaoDoador.excluirDoador();

        verify(this.doadorRepositorio).excluir(Mockito.any(DoadorDto.class));
    }

    @Test
    public void DeveNotificarCodigoInvalido(){
        when(this.exclusaoDoadorDal.obterCodigoDoador()).thenReturn(0);

        this.exclusaoDoador.excluirDoador();

        verify(this.exclusaoDoadorDal).notificarCodigoInvalido();
    }

    @Test
    public void DeveNotificarUsuarioInexistente(){
        when(this.doadorRepositorio.pesquisarPorCodigo(Mockito.anyInt())).thenReturn(null);

        this.exclusaoDoador.excluirDoador();

        verify(this.exclusaoDoadorDal).notificarUsuarioInexistente();
    }
}
