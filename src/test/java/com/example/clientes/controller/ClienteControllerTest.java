package com.example.clientes.controller;

import com.example.clientes.model.Cliente;
import com.example.clientes.service.ClienteService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClienteControllerTest {

    @InjectMocks
    private ClienteController clienteController;

    @Mock
    private ClienteService clienteService;

    public ClienteControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllClientes() {
        // Datos simulados
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setName("John Doe");

        when(clienteService.getAllClientes()).thenReturn(List.of(cliente));

        // Llamada al endpoint
        ResponseEntity<List<Cliente>> response = clienteController.getAllClientes();

        // Validación
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().size());
        assertEquals("John Doe", response.getBody().get(0).getName());
        verify(clienteService, times(1)).getAllClientes();
    }

    @Test
    void testCreateCliente() {
        // Datos simulados
        Cliente cliente = new Cliente();
        cliente.setName("John Doe");

        when(clienteService.createCliente(any(Cliente.class))).thenReturn(cliente);

        // Llamada al endpoint
        ResponseEntity<Cliente> response = clienteController.createCliente(cliente);

        // Validación
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals("John Doe", response.getBody().getName());
        verify(clienteService, times(1)).createCliente(cliente);
    }
}