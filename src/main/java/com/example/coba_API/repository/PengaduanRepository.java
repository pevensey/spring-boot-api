package com.example.coba_API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.coba_API.model.Pengaduan;

import java.util.List;

@Repository
public interface PengaduanRepository extends JpaRepository<Pengaduan, Long> {

}