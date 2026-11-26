import { Component, inject, signal } from '@angular/core';
import { CategoryService } from '../../services/category.services';
import { FormBuilder, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { CategoryResponse } from '../../models/category';
import { FaIconComponent } from '@fortawesome/angular-fontawesome';
import { faEdit, faTrash } from '@fortawesome/free-solid-svg-icons';
import { PoputStoreComponent } from '../../layouts/poput-store-component/poput-store-component';

@Component({
  selector: 'app-category-component',
  imports: [FaIconComponent, FormsModule, PoputStoreComponent, ReactiveFormsModule],
  templateUrl: './category-component.html',
  styleUrl: './category-component.css',
})
export class CategoryComponent {
  private categoryService = inject(CategoryService);
  private fb = inject(FormBuilder);

  category = signal<CategoryResponse[]>([]);
  modalOpen = signal(false);
  saving = signal(false);

  form = this.fb.group({
    name: ['', [Validators.required, Validators.maxLength(100)]],
    description: [''],
    type: [''],
    active: [true],
  });

  ngOnInit() {
    this.cargar();
  }
  cargar() {
    this.categoryService.getAll().subscribe({
      next: (data) => this.category.set(data),
      error: (err) => console.log(err),
    });
  }

  abrir() {
    this.form.reset();
    this.modalOpen.set(true);
  }
  cerrar() {
    this.modalOpen.set(false);
  }

  protected readonly faEdit = faEdit;
  protected readonly faTrash = faTrash;

  protected guardar() {
    if (this.form.invalid) {
      this.form.markAsTouched();
      return;
    }
    const formValues = this.form.getRawValue();

    const payload = {
      ...formValues,
      active: formValues.active ?? false, // Si es null o undefined, será false; si tiene valor, se mantiene
    };

    this.saving.set(true);
    this.categoryService.create(payload).subscribe({
      next: (creada) => {
        this.category.update((list) => [...list, creada]);
        this.saving.set(false);
        console.log('Error in created the Category', creada);
        this.cerrar();
      },
      error: (err) => {
        console.log('Error in created the Category', err);
        this.saving.set(false);
      },
    });
  }
}
