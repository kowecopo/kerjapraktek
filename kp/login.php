<?php 

$conn = mysqli_connect('localhost','root','');
mysqli_select_db($conn, 'kp');

date_default_timezone_set("Asia/Jakarta");

$username = $_POST['username'];
$password = $_POST['password'];
$toilet = $_POST['toilet'];
$login_time = date('Y-m-d H:i:s');

if ($conn) {
	$result = mysqli_query($conn, "SELECT * FROM user WHERE username='$username' AND password='$password'");
	if (mysqli_num_rows($result) > 0) {
		$data = mysqli_fetch_array($result);
		$id_user = $data['id_user'];
		mysqli_query($conn, "INSERT INTO absensi (id_absensi, id_user, waktu_login, waktu_logout, toilet) VALUES ('','$id_user','$login_time','','$toilet')");
		$idabs = mysqli_query($conn, "SELECT id_absensi FROM absensi WHERE id_user='$id_user' AND toilet='$toilet' ORDER BY id_absensi DESC");
		$data1 = mysqli_fetch_array($idabs);
		$idabsnsi = $data1['id_absensi'];
		echo $idabsnsi;
	} else {
		echo "login failed";
	}
} else {
	echo "failed to connect";
}

?>