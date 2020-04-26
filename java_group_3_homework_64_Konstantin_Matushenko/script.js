'use strict'

var serialNumber = 1;

async function addItem() {
    let formData = document.getElementById("itemForm");
    let data = new FormData(formData);
    let item = data.get("item");

    let element = createLiElement(item);
    addLiElement(element);

}

function createLiElement(elem) {
    if (elem.length > 0) {
        let element = document.createElement("li");
        element.id = serialNumber++;
        element.innerHTML = elem;
        element.ondblclick = function () {
            if (element.classList.contains("cl1")) {
                element.classList.remove("cl1")
            } else {
                element.classList.add("cl1");
            }
        };
        document.getElementById('itemForm').reset();
        document.getElementById('f1').focus();
        return element;
    }
    document.getElementById('itemForm').reset();
    document.getElementById('f1').focus();
}

function addLiElement(liElement) {
    document.getElementById("list").appendChild(liElement);
}


// function f(id) {
//     alert(id)
// }