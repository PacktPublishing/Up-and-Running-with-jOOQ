const container = document.getElementById('container');
const loading = document.querySelector('.loading');
const size = 3;

var start = 0;
var theurlparam = '?';

getPost();

function getSelectedAndPost() {

    window.removeEventListener('scroll', iscroll);
    container.innerHTML = '';    
        
    start = 0;
    theurlparam = '?';
    
    var inputPrice = document.querySelectorAll('.pl1');    
    var inputQuantity = document.querySelectorAll('.pl2');    
    
    for (var i = 0; i < inputPrice.length; i++) {
        if(inputPrice[i].checked === true) {
            theurlparam += 'priceEach=' + inputPrice[i].value + "&";
        }
    }
    
    for (var i = 0; i < inputQuantity.length; i++) {
        if(inputQuantity[i].checked === true) {
            theurlparam += 'quantityOrdered=' + inputQuantity[i].value;
        }
    }        
    
    getPost();
}

function infniteScroll() {
    window.addEventListener('scroll', iscroll);
}

function showLoading() {
    window.removeEventListener('scroll', iscroll);
    loading.classList.add('show');
    setTimeout(getPost, 1000)
}

function iscroll() {
    const {scrollTop, scrollHeight, clientHeight} = document.documentElement;

    console.log({scrollTop, scrollHeight, clientHeight});

    if (clientHeight + scrollTop >= scrollHeight - 5) {
        showLoading();
    }
}

async function getPost() {

    const postResponse = await fetch(`/orderdetail/${start}/${size}` + theurlparam);
    const data = await postResponse.json();

    start = data[size - 1].orderdetailId;

    infniteScroll();
    addDataToDOM(data);
}

function addDataToDOM(data) {
    for (var i = 0; i < data.length; i++) {

        const postElement = document.createElement('div');

        postElement.classList.add('orders');
        postElement.innerHTML = `
		<h2 class="title">${data[i].orderdetailId}</h2>
		<p class="text">Order id: ${data[i].orderId} | Order line: ${data[i].orderLineNumber}</p>		
                <div class="user-info">
                    <span>Product id: ${data[i].productId}</span>
                </div>        
                <div class="user-info">
                    <span>Price: $${data[i].priceEach}</span>
                </div>		
                <div class="user-info">
                    <span>Quantity ordered: ${data[i].quantityOrdered}</span>
                </div>		 
	`;

        container.appendChild(postElement);
        loading.classList.remove('show');
    }
}