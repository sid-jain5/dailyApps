export class NumberConvert {
    base1: string
    base2: string
    numberToConvert: string

    constructor(base1: string, base2: string, numberToConvert: string) {
        this.base1 = base1;
        this.base2 = base2;
        this.numberToConvert = numberToConvert;
    }

    convertNum(): string {
        if (this.base1 == '10') {
            console.log("decimal condition")
            return this.convertDecimalToAny();
        }
        else if (this.base1 == '2' || this.base1 == '8') {
            //console.log("bonary condition")
            return this.convertAnyToDecimal();
        }
        else {
            return '1';
        }

    }
    convertDecimalToAny(): string {
        let temp = new Number(this.numberToConvert) //this.numberToConvert;
        return temp.toString(+this.base2);
    }
    convertAnyToDecimal(): string {
        // console.log(+this.base2)
        let temp = +this.numberToConvert;
        let temp2 = 0
        let power = 0
        while (temp > 0) {
            let digit = Number(temp % 10)
            temp2 += Number(Math.pow(+this.base1, power) * digit)
            power = Number(power + 1)
            temp = Number(Math.floor(temp / 10))
        }
        return temp2.toString();
    }

    createHexaMap():any{
        let m = new Map();
        let alpha = 'A'
        let digit = 0
        let map = new Map()
        while (digit < 10) {
            map.set(digit.toString(), digit)
            digit++
        }
        while (digit < 16) {
            map.set(alpha, digit)
            alpha = String.fromCharCode(alpha.charCodeAt(0) + 1)
            digit++
        }

        return m;
    }
    convertHexaToDecimal(): string {
        let m = this.createHexaMap();
        let temp2 = 0
        let power=0
        for (let char of this.numberToConvert){
            let digit = m[char]
            temp2 += (Math.pow(16, power)*digit)
            power++;
        }
        return temp2.toString();
        // for (let entry of map.entries()) {
        //     console.log(entry[0], entry[1]);
        // }

    }
}