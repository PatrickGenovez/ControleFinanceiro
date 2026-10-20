package br.com.devpatrick.controlefinanceiro.repository;

import br.com.devpatrick.controlefinanceiro.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {
    Optional<Conta> findByNumeroConta(int numeroConta);
    Optional<Conta> findByTitularId(int titularId);
}