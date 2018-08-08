<?php 

$conn = mysqli_connect('localhost','root','');
mysqli_select_db($conn, 'kp');

date_default_timezone_set("Asia/Jakarta");

$id_absensi = $_POST['id_absensi'];
$logout_time = date('Y-m-d H:i:s');

if ($conn) {
	$result = mysqli_query($conn, "UPDATE absensi SET waktu_logout='$logout_time' WHERE id_absensi='$id_absensi'");
	if ($result) {
		echo $id_absensi;
	} else {
		echo "update logout gagal";
	}
} else {
	echo "failed to connect";
}

?>