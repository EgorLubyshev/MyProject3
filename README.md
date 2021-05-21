<?php
	echo json_encode([
		"data" => [
			[
				"id" => 1,
				"text" => "Hello World!",
				"checktext" => "проверить",
				"variants" => ["print", "(", '"Hello World!"', ")"],
				"type" => 1
			],
			[
				"id" => 2,
				"text" => "5",
				"checktext" => "проверить",
				"variants" => ["a=3", "b=2", "print(a+b)"],
				"type" => 2
			],
			[
				"id" => 3,
				"text" => "9",
				"checktext" => "проверить",
				"variants" => ["a=3", "for i in range(1,4):", "a+=i","print(a)"],
				"type" => 2
			]
		],
		"status" => true
	]);
?>
