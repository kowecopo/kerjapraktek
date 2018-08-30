<?php 

$conn = mysqli_connect('localhost','root','');
mysqli_select_db($conn, 'kp');

date_default_timezone_set("Asia/Jakarta");

$id_absensi = $_POST['id_absensi'];
$keterangan = $_POST['keterangan'];
$nama_alat = $_POST['nama_alat'];

if ($conn) {
	$result = mysqli_query($conn, "UPDATE data SET keterangan='$keterangan' WHERE id_absensi='$id_absensi' AND nama_alat='$nama_alat'");
	if ($result) {
		echo "success";
	} else {
		echo "gagal";
	}
} else {
	echo "failed to connect";
}

?>