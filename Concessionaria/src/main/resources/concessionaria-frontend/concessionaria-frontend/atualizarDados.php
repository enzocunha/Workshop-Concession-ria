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
                    <a href="index.php" class="btn btn-outline-secondary">
                        Voltar
                    </a>
                </center>
            </div>
            <div class="concessionaria-header p-3 pb-md-4 mx-auto text-center">
                <h1 class="display-4 fw-normal">Concessionária</h1>
                <p class="fs-5 text-muted">Verifique aqui os carros disponíveis para venda e troca.</p>
            </div>
        </header>

        <main>
            <form method="post" id="atualiza-carro">
                <div class="row g-3 justify-content-center">
                    <div class="col-md-5">
                        <label for="carro-id" class="form-label">Escolha o carro que deseja atualizar:</label>
                        <select class="form-select" id="carro-id" name="carro-id" required>
                            <option value="">--</option>
                            <?php
                            for ($i = 0; $i < sizeof($response); $i++) {
                            ?>
                                <option value="<?php echo $response[$i]["id"] ?>"><?php echo $response[$i]["modelo"] ?> - <?php echo $response[$i]["marca"] ?> - <?php echo $response[$i]["ano"] ?></option>
                            <?php } ?>
                        </select>
                    </div>

                    <div class="col-md-5">
                        <label for="ano" class="form-label">Ano</label>
                        <select class="form-select" id="ano" name="ano" required>
                            <option value="2015">2015</option>
                            <option value="2016">2016</option>
                            <option value="2017">2017</option>
                            <option value="2018">2018</option>
                            <option value="2019">2019</option>
                            <option value="2020">2020</option>
                            <option value="2021">2021</option>
                            <option value="2022">2022</option>
                            <option value="2023">2023</option>
                        </select>
                    </div>

                    <div class="col-md-5 align-self-center mr-3">Modelo:
                        <input type="text" class="form-control mr-1" id="modelo" name="modelo" />
                        <div class="input-group mb-4 mr-sm-4"></div>
                    </div>

                    <div class="col-md-5 align-self-center mr-3">Marca:
                        <input type="text" class="form-control mr-1" id="marca" name="marca" />
                        <div class="input-group mb-4 mr-sm-4"></div>
                    </div>

                    <div class="col-md-5 align-self-center mr-3">Cor:
                        <input type="text" class="form-control mr-1" id="cor" name="cor" />
                        <div class="input-group mb-4 mr-sm-4"></div>
                    </div>
                    <div class="col-md-5 align-self-center mr-3">Preço:
                        <input type="number" min="0" max="100" step=".01" class="form-control mr-1" id="preco" name="preco" />
                        <div class="input-group mb-4 mr-sm-4"></div>
                    </div>

                    <div>
                        <input type="hidden" class="form-control form-control-user" id="pagina" name="pagina" value="atualizarDados">
                        <input type="hidden" class="form-control form-control-user" id="acao" name="acao" value="atualizar">
                    </div>
                    <div>
                        <center>
                            <a href="javascript:document.getElementById('atualiza-carro').submit(); " class="w-50 btn btn-primary btn-lg">
                                Atualizar
                            </a>
                        </center>
                    </div>
            </form>
    </div>
    </main>
    <?php
    if (!empty($_POST) && isset($_POST['acao'])) {
        if (empty($_POST['cor']) and empty($_POST['marca']) and empty($_POST['modelo']) and empty($_POST['preco']) and empty($_POST['carro-id'])) {
            echo '</br>
        <div class="col-xl-6 col-lg-6 col-md-6 m-auto">
                              <div class="container-fluid">
                                   <div class="row">
                                        <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 mb-4">
                                             <div class="alert alert-danger"><center>Por favor, preencha todos os dados.</center></div>
                                        </div>
                                   </div>
                              </div>
                         </div>';
        } else {
            $url = 'localhost:8080/carro/' . $_POST['carro-id'];
            $cabecalho = array('Content-Type: application/json', 'Accept: application/json');
            $campos = json_encode(array('ano' => $_POST['ano'], 'cor' => $_POST['cor'], 'marca' => $_POST['marca'], 'modelo' => $_POST['modelo'], 'preco' => $_POST['preco']));

            $ch = curl_init();

            curl_setopt($ch, CURLOPT_URL, $url);
            curl_setopt($ch, CURLOPT_HTTPHEADER, $cabecalho);
            curl_setopt($ch, CURLOPT_POSTFIELDS, $campos);
            curl_setopt($ch, CURLOPT_CONNECTTIMEOUT, 10);
            curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
            curl_setopt($ch, CURLOPT_POST, true);
            curl_setopt($ch, CURLOPT_CUSTOMREQUEST, 'PUT');
            $resposta = json_decode(curl_exec($ch), true);
            curl_close($ch);
            if (sizeof($resposta['errors']) == 0) {
                echo '</br>
                        <div class="col-xl-6 col-lg-6 col-md-6 m-auto">
                              <div class="container-fluid">
                                   <div class="row">
                                        <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 mb-4">
                                             <div class="alert alert-success"><center>Cadastro atualizado com sucesso!</center></div>
                                        </div>
                                   </div>
                              </div>
                         </div>';
            } else {

                echo '</br>
                        <div class="col-xl-6 col-lg-6 col-md-6 m-auto">
                              <div class="container-fluid">
                                   <div class="row">
                                        <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 mb-4">
                                             <div class="alert alert-danger"><center>';
                for ($i = 0; $i < sizeof($resposta["errors"]); $i++) {
                    echo $resposta["errors"][$i];
                    echo '</br>';
                }
                echo '</center></div>
                                        </div>
                                   </div>
                              </div>
                         </div>';
            }
        }
    }

    ?>

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