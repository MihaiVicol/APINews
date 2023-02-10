var startTime = window.performance.now();
let finalUrl = localStorage.getItem("url");

console.log(finalUrl);

let numbers = document.getElementsByClassName("numbers")[0];
var articles = document.getElementsByClassName("results")[0];
var x = 0;

function articles_creation(temp){
    for(var i = 0; i < temp.length; i++){
        var newArticle = document.createElement("div");
        newArticle.classList.add("news-article");
        var tempArticle = `
            <h2 class="url-p"> <a class="url-link" href="${temp[i].url}" > ${temp[i].url}</a></h2>
                    <h2 class="source">${temp[i].source.name}:   </h2>
                    <h2 class="news-title">${temp[i].title}</h2>
                    <h2 class="description"> ${temp[i].description}</h2>
            `;

        newArticle.innerHTML = tempArticle;
        articles.append(newArticle);
        
        
    }
    var endTime = window.performance.now();
    numbers.innerText = "Aproximativ " + temp.length + " rezultate (" +  (endTime-startTime)/1000 + " seconds)";
} 

async function populate() {
    const request = new Request(finalUrl);
    const response = await fetch(request);
    const temp = await response.json();
    console.log(temp);
    articles_creation(temp);
}

populate();





