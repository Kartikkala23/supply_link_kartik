import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-warehouse',
  templateUrl: './warehouse.component.html',
  styleUrls: ['./warehouse.component.scss']
})
export class WarehouseComponent implements OnInit {

  warehouseForm!: FormGroup;
  successMessage = '';
  errorMessage = '';

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    this.warehouseForm = this.fb.group({
     warehouseId: [null, [Validators.required, Validators.min(1)]],
      
      warehouseName: ['', Validators.required],
      location: [''],
      capacity: [0, [Validators.required, Validators.min(0)]]
    });
  }

  onSubmit(): void {
    if (this.warehouseForm.valid) {
      console.log('Warehouse Form Data:', this.warehouseForm.value);
      this.successMessage = 'Warehouse saved successfully!';
      this.errorMessage = '';

      this.warehouseForm.reset({
        supplierId: null,
        warehouseName: '',
        location: '',
        capacity: 0
      });
    } else {
      this.warehouseForm.markAllAsTouched();
      this.errorMessage = 'Please fix validation errors.';
      this.successMessage = '';
    }
  }
}