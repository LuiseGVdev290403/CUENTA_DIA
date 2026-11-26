import { Component, inject, signal } from '@angular/core';
import { TagsServices } from '../../services/tags.services';
import { FormBuilder, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { TagsResponse } from '../../models/tags';
import { FaIconComponent } from '@fortawesome/angular-fontawesome';
import { faEdit, faTrash } from '@fortawesome/free-solid-svg-icons';
import { PoputStoreComponent } from '../../layouts/poput-store-component/poput-store-component';

@Component({
  selector: 'app-tags-component',
  imports: [FaIconComponent, PoputStoreComponent, FormsModule, ReactiveFormsModule],
  templateUrl: './tags-component.html',
  styleUrl: './tags-component.css',
})
export class TagsComponent {
  private tagsService = inject(TagsServices);
  private fb = inject(FormBuilder);

  tags = signal<TagsResponse[]>([]);
  modelOpen = signal(false);
  saving = signal(false);

  form = this.fb.group({
    name: ['', [Validators.required, Validators.maxLength(50)]],
  });

  ngOnInit() {
    this.cargar();
  }
  cargar() {
    this.tagsService.getAll().subscribe({
      next: (data) => {
        this.tags.set(data);
        console.log(data);
      },
      error: (err) => {
        console.log(err);
      },
    });
  }
  abrir() {
    this.form.reset();
    this.modelOpen.set(true);
  }
  cerrar() {
    this.modelOpen.set(false);
  }

  guardar() {
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      return;
    }
    this.saving.set(true);
    this.tagsService.create(this.form.getRawValue()).subscribe({
      next: (creada) => {
        this.tags.update((list) => [...list, creada]);
        this.saving.set(false);
        console.log('Tags saved successfully.');
        this.cerrar();
      },
      error: (err) => {
        console.log('Error in created Tags', err);
        this.saving.set(false);
      },
    });
  }

  protected readonly faTrash = faTrash;
  protected readonly faEdit = faEdit;
}
