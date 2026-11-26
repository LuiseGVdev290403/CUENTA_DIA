export interface CategoryRequest {
  name: string | null;
  description: string | null;
  type: string | null;
  active: boolean | null;
}

export interface CategoryResponse extends CategoryRequest {
  id: number | null;
}
