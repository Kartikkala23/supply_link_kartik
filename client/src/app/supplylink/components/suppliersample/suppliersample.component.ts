import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Supplier } from '../../types/Supplier';
import { of } from 'rxjs';


@Component({
  selector: 'app-suppliersample',
  standalone: true,
  imports: [],
  templateUrl: './suppliersample.component.html',
  styleUrls: ['./suppliersample.component.css'] 
})
export class SupplierSampleComponent {
  supplier:Supplier = new Supplier(1, "John Wane", "johnwane@gmail.com", "9876543210", "texas", "johnwane", "July@101", "USER");
}