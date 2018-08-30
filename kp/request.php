<?php 

$conn = mysqli_connect('localhost','root','');
mysqli_select_db($conn, 'kp');

date_default_timezone_set("Asia/Jakarta");

$nama1 = $_POST['nama1'];
$nama2 = $_POST['nama2'];
$toilet1 = $_POST['toilet1'];
$toilet2 = $_POST['toilet2'];
$jadwal1 = $_POST['jadwal1'];
$jadwal2 = $_POST['jadwal2'];

if ($conn) {
	$result = mysqli_query($conn, "INSERT INTO request (id_request, nama1, jadwal1, toilet1, nama2, jadwal2, toilet2) VALUES ('','$nama1','$jadwal1','$toilet1','$nama2','$jadwal2','$toilet2')");
	if ($result) {
		echo "success";
	} else {
		echo "gagal";
	}
} else {
	echo "failed to connect";
}

?>