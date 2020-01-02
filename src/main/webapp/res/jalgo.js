var array = [1, 5, 7, 9, 3, 22, 11, 54, 29, 87];

var merge_sort = function (array) {

    function merge(left, right) {
        var result = [];
        var il = 0;
        var ir = 0;
        while (il < left.length && ir < right.length) {
            if (left[il] < right[ir]) {
                result.push(left[il++]);
            } else {
                result.push(right[ir++]);
            }
        }
        //merge what is left
        return result.concat(left.slice(il)).concat(right.slice(ir));
    }

    function merge_sort(items) {
        //well it is only 1 element
        if (items.length < 2) {
            return items;
        }
        var middle = Math.floor(items.length / 2);    //create two arrays
        var left = items.slice(0, middle);
        var right = items.slice(middle);
        return merge(merge_sort(left), merge_sort(right));
    }

    return merge_sort(array);
};

function merge(){
    alert("Неотсортированный массив: " + (array));
    alert("Отсортированный массив: " + merge_sort(array));
};
