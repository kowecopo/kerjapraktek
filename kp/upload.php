<?php 

$conn = mysqli_connect('localhost','root','');
mysqli_select_db($conn, 'kp');

date_default_timezone_set("Asia/Jakarta");

$target_dir = "upload";
$image = $_POST['image'];
$image_name = rand()."_".time().".jpeg";
$id_absensi = $_POST['id_absensi'];
$nama_alat = $_POST['nama_alat'];
$waktu = date('H:i:s');

if (!file_exists($target_dir)) {
	mkdir($target_dir, 0777, true);
}

$target_dir = $target_dir."/".$image_name;
if (file_put_contents($target_dir, base64_decode($image))) {

	if ($conn) {
		$result = mysqli_query($conn, "INSERT INTO data (id_absensi, nama_alat, gambar_sebelum, waktu_sebelum, gambar_sesudah, waktu_sesudah) VALUES ('$id_absensi','$nama_alat','$image_name','$waktu','','')");
		if ($result) {
			echo "success";
		} else {
			echo "gagal";
		}
	} else {
		echo "failed to connect";
	}
	
	echo json_encode([
		"Message" => "The file has been uploaded.",
		"Status" => "OK"
	]);
} else {
	echo json_encode([
		"Message" => "Error uploading.",
		"Status" => "Error"
	]);
}

?>