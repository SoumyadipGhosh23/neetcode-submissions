class Solution {
    /**
     * @param {string[]} strs
     * @returns {string}
     */
    encode(strs) {
        const encodedArray = strs.map((ele)=> {
            return Array.from(ele).map((e)=> e.charCodeAt(0)+2)
        });
        console.log(encodedArray)
        const encodedStringOfArray = encodedArray.map((ele)=> {
            return ele.map(e=>String.fromCharCode(e)).join("")
        });
        const encodedString = encodedStringOfArray.map((ele)=>{
            return `${ele.length}#${ele}`
        }).join("");
        console.info(encodedString)
        return encodedString;
    }

    /**
     * @param {string} str
     * @returns {string[]}
     */
    decode(str) {
        let result=[];
        let i = 0;
        while(i<str.length){
            let j = i;
            while(str[j]!== '#') j++;
            const length = parseInt(str.slice(i,j));
            const encodedString = str.slice(j+1,j+1+length)
            result.push(Array.from(encodedString).map(ele=>{
                return String.fromCharCode(ele.charCodeAt(0)-2)
            }).join(""))
            i = j+1+length
        }
        return result
    }
}
