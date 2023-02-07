function testT(obj){
    let temp = document.getElementsByClassName("test")[0];
    temp.innerText = obj;
    console.log(temp.innerText);
}


async function populate() {

    const request = new Request('https://apinews-production.up.railway.app/top');

    const response = await fetch(request);
    const temp = await response.text();
    console.log(temp);

    testT(temp);
}

populate();