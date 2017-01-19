-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Inang: 127.0.0.1
-- Waktu pembuatan: 05 Jan 2017 pada 14.28
-- Versi Server: 5.5.32
-- Versi PHP: 5.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Basis data: `db_perpustakaan`
--
CREATE DATABASE IF NOT EXISTS `db_perpustakaan` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `db_perpustakaan`;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_anggota`
--

CREATE TABLE IF NOT EXISTS `tbl_anggota` (
  `kd_anggota` varchar(5) NOT NULL,
  `nama_anggota` varchar(30) DEFAULT NULL,
  `jenis_kelamin` varchar(11) DEFAULT NULL,
  `tgl_lahir` date DEFAULT NULL,
  `tmp_lahir` varchar(25) DEFAULT NULL,
  `alamat` varchar(25) DEFAULT NULL,
  `no_hp` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`kd_anggota`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_anggota`
--

INSERT INTO `tbl_anggota` (`kd_anggota`, `nama_anggota`, `jenis_kelamin`, `tgl_lahir`, `tmp_lahir`, `alamat`, `no_hp`) VALUES
('1', 'bambang s', 'Laki-Laki', '1996-12-25', 'lumajang', 'pantura', '089678978654'),
('109', 'tukimin', 'Laki-Laki', '1978-12-07', 'jaya baru', 'kampung bambu', '089787657665'),
('12', 'purnama', 'Laki-Laki', '1996-12-06', 'surabaya', 'pematang', '081567816427'),
('14', 'sukimin', 'Laki-Laki', '1998-01-01', 'wubi', 'pajinum', '089768756454'),
('17', 'andi tukinjo sujatmoko', 'Laki-Laki', '1993-05-18', 'tugu agung', 'puncak', '086756432561'),
('18', 'nita', 'Perempuan', '1995-05-01', 'tapak', 'tulung agung', '089787678769'),
('19', 'marissa', 'Perempuan', '1995-06-06', 'dabuk', 'pujangga', '082377689786'),
('89', 'hujani', 'Perempuan', '1998-12-11', 'tapak', 'cendana', '085746576859');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_buku`
--

CREATE TABLE IF NOT EXISTS `tbl_buku` (
  `kode_buku` varchar(13) NOT NULL,
  `judul_buku` varchar(25) DEFAULT NULL,
  `tanggal_beli` date DEFAULT NULL,
  `pengarang` varchar(30) DEFAULT NULL,
  `penerbit` varchar(20) DEFAULT NULL,
  `tahun_terbit` varchar(4) DEFAULT NULL,
  `jlh_buku` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`kode_buku`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_buku`
--

INSERT INTO `tbl_buku` (`kode_buku`, `judul_buku`, `tanggal_beli`, `pengarang`, `penerbit`, `tahun_terbit`, `jlh_buku`) VALUES
('10', 'kopi', '2016-12-20', 'andi', 'matahati', '1998', '12'),
('12', 'terbit', '2016-12-20', 'nas', 'mk', '2011', '12'),
('a', 'satu', '2017-01-18', 'aziz', 'azna', '2013', '1'),
('ui', 'nnm', '2016-12-20', 'nnmm', '', '', '');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_detpeminjaman`
--

CREATE TABLE IF NOT EXISTS `tbl_detpeminjaman` (
  `kd_peminjaman` varchar(5) DEFAULT NULL,
  `kd_buku` varchar(13) DEFAULT NULL,
  `jumlah_pinjam` varchar(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_dpetugas`
--

CREATE TABLE IF NOT EXISTS `tbl_dpetugas` (
  `kd` int(12) NOT NULL,
  `username` varchar(30) NOT NULL,
  `pass` varchar(15) NOT NULL,
  `level` enum('Admin','Petugas','Administrasi','') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_dpetugas`
--

INSERT INTO `tbl_dpetugas` (`kd`, `username`, `pass`, `level`) VALUES
(0, 'madewiranata', '123', 'Admin'),
(0, 'made', 'made', 'Admin');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_peminjaman`
--

CREATE TABLE IF NOT EXISTS `tbl_peminjaman` (
  `kd_peminjaman` varchar(5) NOT NULL,
  `tgl_pinjam` date DEFAULT NULL,
  `kd_petugas` varchar(5) DEFAULT NULL,
  `kd_anggota` varchar(5) DEFAULT NULL,
  `jlh_pinjam` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`kd_peminjaman`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_peminjaman`
--

INSERT INTO `tbl_peminjaman` (`kd_peminjaman`, `tgl_pinjam`, `kd_petugas`, `kd_anggota`, `jlh_pinjam`) VALUES
('12', '2016-12-22', '2', '1', '1'),
('13', '2016-12-22', '12', '1', '1'),
('18', '2016-12-02', '1', '1', '1'),
('56', '2016-12-22', '2', '1', '1');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_pengembalian`
--

CREATE TABLE IF NOT EXISTS `tbl_pengembalian` (
  `kd_pengembalian` varchar(5) DEFAULT NULL,
  `tgl_pengembalian` date DEFAULT NULL,
  `kd_peminjaman` varchar(5) DEFAULT NULL,
  `keterlambatan` varchar(15) DEFAULT NULL,
  `denda` varchar(7) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_pengembalian`
--

INSERT INTO `tbl_pengembalian` (`kd_pengembalian`, `tgl_pengembalian`, `kd_peminjaman`, `keterlambatan`, `denda`) VALUES
('15', '2016-12-22', '12', '4', '8000');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_perpus`
--

CREATE TABLE IF NOT EXISTS `tbl_perpus` (
  `no_buku` int(11) NOT NULL,
  `judul_buku` varchar(40) DEFAULT NULL,
  `pengarang` varchar(25) DEFAULT NULL,
  `tahun` int(4) DEFAULT NULL,
  `penerbit` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`no_buku`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_perpus`
--

INSERT INTO `tbl_perpus` (`no_buku`, `judul_buku`, `pengarang`, `tahun`, `penerbit`) VALUES
(23, 'dsd', 'ds', 211, 'sd');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_petugas`
--

CREATE TABLE IF NOT EXISTS `tbl_petugas` (
  `kd_petugas` varchar(5) NOT NULL,
  `nm_petugas` varchar(25) DEFAULT NULL,
  `password` varchar(15) DEFAULT NULL,
  `akses` enum('Admin','Petugas','Administrasi') DEFAULT NULL,
  PRIMARY KEY (`kd_petugas`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_petugas`
--

INSERT INTO `tbl_petugas` (`kd_petugas`, `nm_petugas`, `password`, `akses`) VALUES
('1', 'wira', '123', 'Admin'),
('12', 'nata', '321', 'Petugas'),
('2', 'made wiranata', '123', 'Admin'),
('3', 'made', '456', 'Administrasi');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
