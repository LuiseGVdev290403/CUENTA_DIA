import { Component, inject, OnInit, signal } from '@angular/core';
import { AccountServices } from '../../services/account.services';
import { AccountRequest, AccountResponse } from '../../models/account';
import { faEdit, faTrash } from '@fortawesome/free-solid-svg-icons';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { PoputStoreComponent } from '../../layouts/poput-store-component/poput-store-component';
import { FaIconComponent } from '@fortawesome/angular-fontawesome';

@Component({
  selector: 'app-account-component',
  imports: [PoputStoreComponent, ReactiveFormsModule, FaIconComponent],
  templateUrl: './account-component.html',
  styleUrl: './account-component.css',
})
export class AccountComponent implements OnInit {
  private accountService = inject(AccountServices);
  private fb = inject(FormBuilder);

  accounts = signal<AccountResponse[]>([]);
  modalOpen = signal(false);
  saving = signal(false);

  form = this.fb.group({
    name: ['', [Validators.required]],
    initialBalance: Number(['', [Validators.required]]),
    type: [''],
  });

  ngOnInit() {
    this.cargar();
  }
  cargar() {
    this.accountService.getAll().subscribe({
      next: (data) => this.accounts.set(data),
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
  crear() {
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      return;
    }
    this.saving.set(true);
    this.accountService.create(this.form.getRawValue()).subscribe({
      next: (creada) => {
        this.accounts.update((list) => [...list, creada]);
        this.saving.set(false);
        console.log('Account created', creada);
        this.cerrar();
      },
      error: (err) => {
        console.log('error in created the  account', err);
        this.saving.set(false);
      },
    });
  }
  eliminar(id: number) {
    this.accountService.deleted(id).subscribe({
      next: () => this.accounts.update((list) => list.filter((item) => item.id !== id)),
      error: (err) => console.log(err),
    });
  }

  protected readonly faEdit = faEdit;
  protected readonly faTrash = faTrash;
}
