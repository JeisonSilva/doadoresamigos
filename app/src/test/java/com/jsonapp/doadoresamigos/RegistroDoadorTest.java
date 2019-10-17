package com.jsonapp.doadoresamigos;

import com.jsonapp.doadoresamigos.gestaodoadores.DoadorDto;
import com.jsonapp.doadoresamigos.gestaodoadores.DoadorRepositorio;
import com.jsonapp.doadoresamigos.gestaodoadores.RegistroDoador;
import com.jsonapp.doadoresamigos.gestaodoadores.RegistroDoadorDal;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RegistroDoadorTest {

    private RegistroDoador registroDoador;
    private RegistroDoadorDal registroDoadorDal;
    private DoadorRepositorio doadorRepositorio;

    @Before
    public void configurarTestes(){

        this.registroDoadorDal = Mockito.mock(RegistroDoadorDal.class);
        this.doadorRepositorio = Mockito.mock(DoadorRepositorio.class);
        this.registroDoador = new RegistroDoador(this.registroDoadorDal, this.doadorRepositorio);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void DeveRegistrarDoador(){
        when(this.registroDoadorDal.obterDadosInformadosPeloUsuario()).thenReturn(new DoadorDto());

        this.registroDoador.registrar();

        verify(this.doadorRepositorio).registrar(Mockito.any(DoadorDto.class));
    }
}
