<!doctype html>
<?php
$url = "localhost:8080/carro";
$curl = curl_init();

// Configura
curl_setopt_array($curl, [
  CURLOPT_RETURNTRANSFER => 1,
  CURLOPT_URL => 'localhost:8080/carro'
]);

// Envio e armazenamento da resposta
$response = json_decode(curl_exec($curl), true);
// Fecha e limpa recursos
curl_close($curl);
?>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
  <meta name="generator" content="Hugo 0.108.0">
  <title>Concessionária</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
  <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/concessionaria/">
  <link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">

  <style>
    .bd-placeholder-img {
      font-size: 1.125rem;
      text-anchor: middle;
      -webkit-user-select: none;
      -moz-user-select: none;
      user-select: none;
    }

    @media (min-width: 768px) {
      .bd-placeholder-img-lg {
        font-size: 3.5rem;
      }
    }

    .b-example-divider {
      height: 3rem;
      background-color: rgba(0, 0, 0, .1);
      border: solid rgba(0, 0, 0, .15);
      border-width: 1px 0;
      box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
    }

    .b-example-vr {
      flex-shrink: 0;
      width: 1.5rem;
      height: 100vh;
    }

    .bi {
      vertical-align: -.125em;
      fill: currentColor;
    }

    .nav-scroller {
      position: relative;
      z-index: 2;
      height: 2.75rem;
      overflow-y: hidden;
    }

    .nav-scroller .nav {
      display: flex;
      flex-wrap: nowrap;
      padding-bottom: 1rem;
      margin-top: -1px;
      overflow-x: auto;
      text-align: center;
      white-space: nowrap;
      -webkit-overflow-scrolling: touch;
    }
  </style>


  <!-- Custom styles for this template -->
  <link href="concessionaria.css" rel="stylesheet">
</head>

<body>

  <svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
    <symbol id="check" viewBox="0 0 16 16">
      <title>Check</title>
      <path d="M13.854 3.646a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708 0l-3.5-3.5a.5.5 0 1 1 .708-.708L6.5 10.293l6.646-6.647a.5.5 0 0 1 .708 0z" />
    </symbol>
  </svg>

  <div class="container py-3">
    <header>
    <div class="d-flex justify-content-end">
                <center>
                    <a href="atualizarDados.php" class="btn btn-outline-secondary">
                        Atualizar carros
                    </a>
                </center>
            </div>
      <div class="concessionaria-header p-3 pb-md-4 mx-auto text-center">
        <h1 class="display-4 fw-normal">Concessionária</h1>
        <p class="fs-5 text-muted">Verifique aqui os carros disponíveis para venda e troca.</p>
      </div>
    </header>

    <main>

      <div class="row row-cols-1 row-cols-md-3 mb-3 text-center">
        <?php for ($i = 0; $i < sizeof($response); $i++) {
        ?>
          <div class="col">
            <div class="card mb-4 rounded-3 shadow-sm">
              <div class="card-header py-3">
                <img src="carro.png" height="100" width="150" alt="Carro exemplo">
              </div>
              <div class="card-body">
                <h1 class="card-title concessionaria-card-title">R$ <?php echo $response[$i]['preco']; ?><small class="text-muted fw-light"></small></h1>
                <ul class="list-unstyled mt-3 mb-4">
                  <li><?php echo $response[$i]['modelo']; ?> - <?php echo $response[$i]['marca']; ?></li>
                  <li><?php echo $response[$i]['ano']; ?></li>
                </ul>
                <button type="button" class="w-100 btn btn-lg btn-outline-primary">Saiba mais</button>
              </div>
            </div>
          </div>
        <?php
        } ?>
      </div>


  </div>
  </main>

  <footer class="pt-4 my-md-5 pt-md-5 border-top">
        <div class="row">
            <center>
            <div class="col-12 col-md">
                <small class="d-block mb-3 text-muted">&copy; 2023 - Enzo, Gabriel e Natália</small>
            </div>
            </center>
        </div>
    </footer>
  </div>



</body>

</html>