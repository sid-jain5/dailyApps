import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NumberConvert } from '../converters/numberConvert'
import { element } from 'protractor';

@Component({
  selector: 'app-converter',
  templateUrl: './converter.component.html',
  styleUrls: ['./converter.component.css']
})
export class ConverterComponent implements OnInit {

  currentConverter: String = 'choose';
  convertForm: FormGroup
  label1: String = "Binary Number:"
  label2: String = "Decimal Number:"
  validatePattern: string = '^[01]{1,20}$'
  // convertList = ['length', 'weight', 'temperature', 'number system', 'computer memory']
  convertMap = this.createConvertTypelist()

  constructor(private fb: FormBuilder) { 
  }

  ngOnInit() {
    this.convertForm = this.fb.group({
      binaryNumber: ['', [Validators.required, Validators.pattern(this.validatePattern)]],
      decimalNumber: ['']
    });

    this.onChanges();
  }

  onChanges(): void {
    this.convertForm.get('binaryNumber').valueChanges.subscribe(val => {
      if (this.convertForm.get('binaryNumber').valid)
        this.convert();
      else {
        alert("illegal value")
        let a = this.convertForm.get('binaryNumber').value
        a = Math.floor(a / 10)
        this.convertForm.patchValue(
          {
            binaryNumber: a
          }
        )
        this.onChanges();
      }
    })
  }

  onChange1(obj) {
    this.currentConverter = obj
    if (obj == "number system") {
      alert("continue")
    }
    else {
      //console.log("here")
      alert("feature not available yet")
    }
  }

  onChange2(obj) {
    alert("sub menu item")
  }
  createConvertTypelist() {
    let convertList = new Map()
    convertList.set('length', ['deca', 'hecto', 'kilo', 'mega', 'giga', 'tera', 'peta'])
    convertList.set('weight', ['abc', 'def'])

    convertList.set('temperature', ['celcius', 'farenheit', 'kelvin'])
    convertList.set('number system', ['binary', 'decimal', 'octa', 'hexadecimal'])
    convertList.set('computer memory', ['bits', 'bytes', 'kb', 'mb', 'gb', 'tb'])

    return convertList
  }

  convert() {
    let temp = Number(this.convertForm.get('binaryNumber').value)

    let nc: NumberConvert = new NumberConvert('2', '10', temp.toString());
    let ans: string = nc.convertNum()
    //console.log(this.convertForm.get('binaryNumber').value)
    // let temp2 = 0
    // let power=0
    // while(temp>0){
    //   let digit = Number(temp%10)
    //   temp2 += Number(Math.pow(2,power)*digit)
    //   power = Number(power+1)
    //   temp= Number(Math.floor(temp/10))
    // }
    this.convertForm.patchValue(
      {
        decimalNumber: ans
      }
    )
    // this.decimalValue=temp2
  }

}
