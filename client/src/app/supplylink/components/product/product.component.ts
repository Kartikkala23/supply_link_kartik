import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
    selector: 'app-product',
    templateUrl: './product.component.html',
    styleUrls: ['./product.component.scss']
})
export class ProductComponent implements OnInit {
    productForm!: FormGroup;

    constructor() { }

    ngOnInit(): void {
        this.productForm = new FormGroup({
            productId: new FormControl(''),
            warehouseId: new FormControl('', [
                Validators.required,
                Validators.min(1)
            ]),
            productName: new FormControl('', [
                Validators.required
            ]),
            productDescription: new FormControl(''),
            quantity: new FormControl('', [
                Validators.required,
                Validators.min(0) // Must be non-negative
            ]),
            price: new FormControl('', [
                Validators.required,
                Validators.min(1) // Must be greater than 0
            ])
        });
    }

    onSubmit(): void {
        if (this.productForm.valid) {
            const productInstance = this.productForm.value;
            console.log('Product Instance Created:', productInstance);
            // Logic for further processing (e.g., API call) goes here
        }
    }
}