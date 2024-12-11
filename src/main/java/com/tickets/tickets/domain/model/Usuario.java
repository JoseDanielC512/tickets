package com.tickets.tickets.domain.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String correo;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    @Column(nullable = false)
    private LocalDateTime fechaActualizacion;

    // Campos adicionales según la API de GitHub
    @Column(nullable = false, unique = true)
    private String login; // Identificador de usuario en GitHub

    @Column(nullable = false)
    private Long idGitHub; // ID del usuario en GitHub

    @Column(nullable = true)
    private String avatarUrl; // URL del avatar del usuario

    @Column(nullable = true)
    private String htmlUrl; // URL del perfil público de GitHub

    @Column(nullable = true)
    private Integer followers; // Número de seguidores del usuario en GitHub

    @Column(nullable = true)
    private Integer following; // Número de personas que sigue el usuario en GitHub

    @Column(nullable = true)
    private String reposUrl; // URL para acceder a los repositorios del usuario en GitHub
}
