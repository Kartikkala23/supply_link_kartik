import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { BehaviorSubject } from 'rxjs';
import { Supplier } from '../../types/Supplier';



@Component({
  selector: 'app-supplier',
  templateUrl: './supplier.component.html',
  styleUrls: ['./supplier.component.scss']
})
export class SupplierComponent implements OnInit {
  supplierForm!: FormGroup;

  supplier: Supplier = new Supplier(
    1,
    'Alice Johnson',
    'alice@example.com',
    '1234567890',
    '123 Main St',
    'alicej',
    'pass123',
    'Admin'
  );

  supplierSuccess$ = new BehaviorSubject<boolean>(false);
  supplierError$ = new BehaviorSubject<boolean>(false);

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    this.supplierForm = this.fb.group({
      name: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  onSubmit(): void {
    if (this.supplierForm.valid) {
      this.supplierSuccess$.next(true);
      this.supplierError$.next(false);
      console.log('Supplier created:', this.supplierForm.value);
      this.supplierForm.reset();
    } else {
      this.supplierSuccess$.next(false);
      this.supplierError$.next(true);
    }
  }
}