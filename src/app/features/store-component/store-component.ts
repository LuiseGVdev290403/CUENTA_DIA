import { Component, inject, OnInit, signal } from '@angular/core';
import { StoreServices } from '../../services/store.servoces';
import { StoreResponse } from '../../models/store';
import { PoputStoreComponent } from '../../layouts/poput-store-component/poput-store-component';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { FaIconComponent } from '@fortawesome/angular-fontawesome';
import { faEdit, faTrash } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-store-component',
  imports: [PoputStoreComponent, ReactiveFormsModule, FaIconComponent],
  templateUrl: './store-component.html',
  styleUrl: './store-component.css',
})
export class StoreComponent implements OnInit {
  private storeService = inject(StoreServices);
  private fb = inject(FormBuilder);

  stores = signal<StoreResponse[]>([]);
  modalOpen = signal(false);
  saving = signal(false);

  form = this.fb.group({
    name: ['', [Validators.required, Validators.maxLength(100)]],
    description: [''],
  });

  ngOnInit() {
    this.cargar();
  }

  cargar() {
    this.storeService.getAll().subscribe({
      next: (data) => {
        this.stores.set(data);
        console.log(data);
      },
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

  guardar() {
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      return;
    }
    this.saving.set(true);
    this.storeService.create(this.form.getRawValue()).subscribe({
      next: (creada) => {
        this.stores.update((list) => [...list, creada]);
        this.saving.set(false);
        console.log('Error in created the store', creada);
        this.cerrar();
      },
      error: (err) => {
        console.log('Error in created the store', err);
        this.saving.set(false);
      },
    });
  }

  protected readonly faEdit = faEdit;
  protected readonly faTrash = faTrash;
}
