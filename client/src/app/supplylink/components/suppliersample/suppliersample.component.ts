import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Supplier } from '../../types/Supplier';
import { of } from 'rxjs';

@Component({
  selector: 'app-suppliersample',
  standalone: true,
  imports: [], // Add necessary imports
  templateUrl: './suppliersample.component.html',
  styleUrls: ['./suppliersample.component.css'],
  template: 'Supplier Details :<br>Supplier ID: {{supplier.supplierId}}<br>Name: {{supplier.supplierName}}<br>Email: {{supplier.email}}<br>Phone: {{supplier.phone}}<br>Address: {{supplier.address}}<br>Username: {{supplier.username}}<br>Password: {{supplier.password}}<br>Role: {{supplier.role}}',

})
export class SupplierSampleComponent {
  // Component logic goes here
  supplier = new Supplier(1, "John Wane", "johnwane@gmail.com", "9876543210", "texas", "johnwane", "July@101", "USER");

}