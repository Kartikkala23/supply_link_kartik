import { Component } from '@angular/core';
import { Supplier } from '../../types/Supplier';

@Component({
  selector: 'app-suppliersample',
  standalone: true,
  imports: [], // Add Angular common modules if needed (e.g., NgIf, NgFor)
  templateUrl: './suppliersample.component.html',
  styleUrls: ['./suppliersample.component.css']
})
export class SupplierSampleComponent {
  supplier: Supplier;

  constructor() {
    // Bind sample data to Supplier
    this.supplier = new Supplier(
      1,
      'Global Supplies Ltd',
      'contact@globalsupplies.com',
      '9876543210',
      '123 Market Street, Hyderabad',
      'globalsupplier',
      'securePass123',
      'admin'
    );
  }
}