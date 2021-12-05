function gerarMatricula(){
    
    var txt  = "MOP"
    var aleatorio = Math.floor(Math.random()*1200)
    document.getElementById("matricula").value = txt + aleatorio
   
}