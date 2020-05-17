-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 17 Bulan Mei 2020 pada 14.40
-- Versi server: 10.4.11-MariaDB
-- Versi PHP: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `studiomusik`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `studio`
--

CREATE TABLE `studio` (
  `studio_id` char(6) NOT NULL,
  `studio_type` varchar(32) NOT NULL,
  `studio_price` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `studio`
--

INSERT INTO `studio` (`studio_id`, `studio_type`, `studio_price`) VALUES
('R001', 'Regular', 50000),
('V001', 'VIP', 100000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `studioorder`
--

CREATE TABLE `studioorder` (
  `order_id` int(6) NOT NULL,
  `name` varchar(32) NOT NULL,
  `studio_id` char(6) NOT NULL,
  `order_price` int(9) NOT NULL,
  `order_time` datetime NOT NULL,
  `order_play` datetime NOT NULL,
  `order_finish` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `studio`
--
ALTER TABLE `studio`
  ADD PRIMARY KEY (`studio_id`);

--
-- Indeks untuk tabel `studioorder`
--
ALTER TABLE `studioorder`
  ADD PRIMARY KEY (`order_id`),
  ADD KEY `studio_id` (`studio_id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `studioorder`
--
ALTER TABLE `studioorder`
  MODIFY `order_id` int(6) NOT NULL AUTO_INCREMENT;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `studioorder`
--
ALTER TABLE `studioorder`
  ADD CONSTRAINT `studioorder_ibfk_1` FOREIGN KEY (`studio_id`) REFERENCES `studio` (`studio_id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
