let a = document.getElementsByClassName("rating")
let temp = ""
for (var i = 0; i < a.length; i++) {
		 let value = parseFloat(a[i].innerText)
     let stars = value/0.2
     stars = stars.toPrecision(1)
     for(let e = 1; e <= stars; e++){
         temp += " STAR"
     }
     temp = value + "/1.0" + temp
     a[i].innerHTML = temp;
     temp = ""
}