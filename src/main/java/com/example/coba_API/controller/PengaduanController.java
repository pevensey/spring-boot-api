package com.example.coba_API.controller;

import com.example.coba_API.model.Pengaduan;
import com.example.coba_API.repository.PengaduanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pengaduan")
public class PengaduanController {
	@Autowired
	PengaduanRepository pengaduanrepo;

    @RequestMapping("/hellopengaduan")
    public String hello(){
        return "Hello pengaduan";
    }

	@GetMapping("/")
	public List<Pengaduan> getAll(){
	return pengaduanrepo.findAll();
	}

	@PostMapping("/")
	public Pengaduan tambahAduan(@Valid @RequestBody Pengaduan pengaduan) {
	return pengaduanrepo.save(pengaduan);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Pengaduan> updatePengaduan(@PathVariable(value="id")Long id,
	@Valid @RequestBody Pengaduan detailPengaduan){
	Pengaduan Pengaduan = pengaduanrepo.findOne(id);
	if(Pengaduan == null)
	return ResponseEntity.notFound().build();
	Pengaduan.setid_pengaduan(detailPengaduan.getid_pengaduan());
	Pengaduan.setemail(detailPengaduan.getemail());
	Pengaduan.setnama(detailPengaduan.getnama());
	Pengaduan.setisi_aduan(detailPengaduan.getisi_aduan());
	Pengaduan.setno_telepon(detailPengaduan.getno_telepon());
	Pengaduan updatedPengaduan = pengaduanrepo.save(detailPengaduan);
	return ResponseEntity.ok(updatedPengaduan);
	}

	@DeleteMapping("/{id}")
	public String deleteHotel(@PathVariable (value="id") Long id){
	Pengaduan Pengaduan = pengaduanrepo.findOne(id);
	String result = "";
	if(Pengaduan == null) {
	result = "id "+id+" tidak ditemukan";
	return result;
	}
	result = "id "+id+" berhasil di hapus";
	pengaduanrepo.delete(id);
	return result;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pengaduan> getHotelById(@PathVariable(value="id") Long id){
	Pengaduan pengaduan = pengaduanrepo.findOne(id);
	if(pengaduan == null)
	return ResponseEntity.notFound().build();
	return ResponseEntity.ok().body(pengaduan);
	}

//	@GetMapping("/sortPengaduan")
//	public List<Pengaduan> sortHotel(@RequestParam(value="nama")String nama_hotel){
//	return pengaduanrepo.findByNamaHotel(nama_hotel);
//	}

//	@GetMapping("/sortstatus/{statusPeminjaman}")
//	public List<Pengaduan> sortstatus(@PathVariable(value="statusPeminjaman") int statusPeminjaman){
//	return pengaduanrepo.findByStatusPeminjaman(statusPeminjaman);
//	}
}
