package br.com.banco.repositories;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.banco.models.Transferencia;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

	List<Transferencia> findByContaId(Long id);

	@Query("SELECT t FROM Transferencia t WHERE t.conta.id = :id AND t.dataDeTransferencia BETWEEN :dataInicio AND :dataFim")
	List<Transferencia> findByContaIdBetween(Long id, OffsetDateTime dataInicio, OffsetDateTime dataFim);

}
