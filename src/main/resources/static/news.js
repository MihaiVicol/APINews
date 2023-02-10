let finalUrl = "";

let keyWord = document.getElementsByClassName("keyword-input")[0];
let startDate = document.getElementsByClassName("start-date")[0];
let endDate = document.getElementsByClassName("end-date")[0];
let searchBtn1 = document.getElementsByClassName("first-side-button")[0];

let country = document.getElementsByClassName("country-input")[0];
let topic = document.getElementsByClassName("topic-input")[0];
let searchBtn2 = document.getElementsByClassName("second-side-button")[0];

searchBtn1.onclick = () => {
    if (keyWord.value != 0 && startDate != 0 && endDate != 0) {
        populate1();
        localStorage.setItem("url", finalUrl);
        window.location.replace("results.html");
    }
    else {

    }

}

searchBtn2.onclick = () => {
    if (country.value != 0 && topic.value != 0) {
        populate2();
        localStorage.setItem("url", finalUrl);
        window.location.replace("results.html");
    }
    else {

    }

}

async function populate1() {
    let arrayT = keyWord.value.split(" ");
    let url = "https://apinews-production.up.railway.app/top/";
    for(var i = 0 ; i < arrayT.length; i++){
        if(i != arrayT.length - 1 ) 
            url = url + arrayT[i] + "-";
        else 
            url = url + arrayT[i] + "/";
    }
    url = url + startDate.value + "/" + endDate.value;
    console.log(url);
    finalUrl = url;
    
}

async function populate2() {

    let url = "https://apinews-production.up.railway.app/top/";
    url = url + country.value + "/" + topic.value;
    console.log(url);
    finalUrl = url;
}


var chng = 1;
let changer = document.getElementsByClassName("changer")[0];
let firstSide = document.getElementsByClassName("first-side")[0];
let secondSide = document.getElementsByClassName("second-side")[0];

changer.onclick = () => {
    if (chng == 1) {
        firstSide.classList.add("active");
        secondSide.classList.add("active");
        chng = 0;
    }
    else {
        firstSide.classList.remove("active");
        secondSide.classList.remove("active");
        chng = 1
    }

}

