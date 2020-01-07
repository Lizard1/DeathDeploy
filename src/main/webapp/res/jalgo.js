var array2 = [5, 1, 9, 7, 22, 3, 54, 11, 87, 29];
i = 1;

function InsertionSort() {
    var arrPrint = document.getElementById("printArray");
    arrPrint.innerHTML = array2;

    if (i < array2.length) {
        var v = array2[i];
        var j = i - 1;
        while (j >= 0 && array2[j] > v) {
            array2[j + 1] = array2[j];
            j--;
        }
        array2[j + 1] = v;
        i++;
    }
}

function sortMyArray() {
    setInterval(InsertionSort, 400);
}