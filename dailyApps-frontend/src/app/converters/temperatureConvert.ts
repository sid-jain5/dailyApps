export class TemperatureConvert{
    base1: string
    base2: string
    numberToConvert: number
    
    constructor(base1: string, base2: string, numberToConvert: string) {
        this.base1 = base1;
        this.base2 = base2;
        this.numberToConvert = Number(numberToConvert);
    }
    convert():string{
        if(this.base1=='celcius'){
            return this.convertFromCelcius(this.numberToConvert)
        }
        else if(this.base1=='farenheit'){
            if(this.base2!='kelvin')
                return this.convertFromFarenheit(this.base2, this.numberToConvert)
            else{
                let cel:string = this.convertFromFarenheit('celcius', this.numberToConvert)
                return this.convertFromCelcius(Number(cel))
            }
        }
        else if(this.base1=='kelvin'){
            if(this.base2!='farenheit')
                return this.convertFromKelvin(this.base2, this.numberToConvert)
            else{
                let cel:string = this.convertFromKelvin('celcius', this.numberToConvert)
                return this.convertFromCelcius(Number(cel))
            }
        }
        else{
            alert(this.base1)
            return ''
        }
    }
    convertFromCelcius(cel):string{
        let ans=''
        if(this.base2=='kelvin'){
            ans = (cel+273.15).toFixed(2).toString()
        }
        else if(this.base2=='farenheit'){
            ans = ((cel*(9/5))+32).toFixed(2).toString()
        }
        else if(this.base2==this.base1){
            ans=cel.toFixed(2).toString()
        }
        else{
            alert(this.base2)
        }
        return ans
    }

    convertFromFarenheit(base2:string, numberToConvert:number):string{
        let ans=''
        if(base2=='celcius'){
            let temp = (numberToConvert-32)*(5/9)
            ans = temp.toFixed(2).toString()
        }
        // else if(this.base2=='kelvin'){

        // }
        else if(base2==this.base1){
            ans=this.numberToConvert.toFixed(2).toString()
        }
        else{
            alert(this.base2)
        }
        return ans
    }
    convertFromKelvin(base2:string, numberToConvert:number):string{
        let ans=''
        if(base2=='celcius'){
            ans = (numberToConvert-273.15).toFixed(2).toString()
        }
        // else if(this.base2=='farenheit'){
            
        // }
        else if(base2==this.base1){
            ans=this.numberToConvert.toFixed(2).toString()
        }
        else{
            alert(this.base2)
        }
        return ans
    }
}